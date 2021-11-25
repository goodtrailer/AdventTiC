"""
usage: drop into a directory with a bunch of images (i.e. ingot images) along
with a mask.png of the same dimensions. use gray pixels on the mask image to
pick out the colors on each picture, and those colors will be output into
palette-output.txt in TiC MaterialSpriteInfoBuilder methods. see a
MaterialSpriteProvider class for an example of how to use the output.
"""

from PIL import Image, ImageOps
from statistics import mean
import os

def extract_palette():
    mask_file = "mask.png"
    mask = Image.open(mask_file)
    mask_raw = mask.convert("RGBA").load()
    
    # x, y, value
    mask_pixels = []
    width, height = mask.size
    for x in range(width):
        for y in reversed(range(height)):
            if (mask_raw[x, y][3] != 0):
                mask_pixels.append((x, y, int(mean(mask_raw[x, y][0:3]))))
    mask_pixels.sort(key = lambda mask_pixel: mask_pixel[2])
    
    for i in range(len(mask_pixels)):
        print("found mask px: (%d, %d), %d" % mask_pixels[i])
        
    output_file = "palette-output.txt"
    if (os.path.exists(output_file)):
        os.remove(output_file)
    
    for file in os.listdir(os.getcwd()):
        if (not file.endswith(".png")):
            continue
            
        if (file == mask_file):
            continue
            
        img = Image.open(file)
        if (img.size != mask.size):
            continue
        
        print("processing " + file + "...")
        output = "\n".join((file[:-4],
            "---",
            ".meleeHarvest()",
            ".fallbacks(\"metal\")",
            ".colorMapper(GreyToColorMapping",
            ".builderFromBlack()"))
        format = "\n.addARGB(%d, 0x%02X%02X%02X%02X)"
        
        img_raw = img.convert("RGBA").load()
        for i in range(len(mask_pixels)):
            x, y, gray_value = mask_pixels[i]
            pixel = img_raw[x, y]
            output += format % (gray_value, pixel[3], pixel[0], pixel[1], pixel[2])
        
        output += "\n.build())\n\n"
        with open(output_file, "a") as f:
            f.write(output)

if __name__ == "__main__":
    extract_palette()
