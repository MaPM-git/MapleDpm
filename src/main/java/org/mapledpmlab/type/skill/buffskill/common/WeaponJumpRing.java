package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class WeaponJumpRing extends BuffSkill {
    public WeaponJumpRing(Long weaponAttMagic) {
        this.setName("웨폰퍼프 링(4레벨)");
        this.setCooldown(180.0);
        this.setDuration(15L);
        this.setDelay(30L);
        this.setBuffMainStat(weaponAttMagic * 5);
    }
}
