<img src="src/main/resources/logo.png" alt="AdventTiC" width="300" height="300">

# AdventTiC
[Advent of Ascension](https://github.com/Tslat/Advent-Of-Ascension) integration mod for [Tinkers' Construct](https://github.com/SlimeKnights/TinkersConstruct) 1.16.5.

AoA had TiC integration in 1.12.2, but because TiC is still only in alpha for 1.16.5, that integration hasn't yet been ported. This mod is a stopgap for one of my modpacks until Tslat re-implements TiC integration for 1.16.5.

### Accuracy
**TL;DR:** It's not an exact port of the TiC integration from AoA 1.12.2. I took some creative liberties.

TiC 1.16.5 has pretty big changes from 1.12.2, such as modifier slots. Since 1.12.2 doesn't have modifier slots, I just selected slots based on what felt right.

Some stats are based on values from the [official wiki](https://adventofascension.fandom.com/wiki/Third-Party_Mod_Integration/Tinker%27s_Construct), which sometimes conflicts with values from the [1.12.2 source](https://github.com/Tslat/Advent-Of-Ascension/tree/f6e05fc886ddc3d391a5f54e893cbdf9859ea939/source/hooks/tconstruct). Sometimes, I just preferred the wiki's values, even though they were wrong.

Also, some modifiers/traits have received substantial changes because I felt like it, i.e. [Evil Pressure](src/main/java/goodtrailer/adventtic/traits/EvilPressureModifier.java). For Evil Pressure, I just thought the original implementaion made it completely underpowered and unusable.

### Credits
This mod depends on:
* [Advent of Ascension](https://github.com/Tslat/Advent-Of-Ascension) by [Tslat](https://github.com/Tslat)
* [Tinkers Construct](https://github.com/SlimeKnights/TinkersConstruct) by the [Slime Knights](https://github.com/orgs/SlimeKnights/people)
* [Mantle](https://github.com/SlimeKnights/Mantle) by the [Slime Knights](https://github.com/orgs/SlimeKnights/people)

Additional translations:
* 简体中文 (Simplified Chinese) by [Kasualix](https://github.com/Kasualix)
