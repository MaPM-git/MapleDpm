package org.mapledpmlab.type.skill.buffskill.cannonshooter;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.cannonshooter.BarrelRouletteSkull;
import org.mapledpmlab.type.skill.attackskill.cannonshooter.MonkeyBombBasic;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SpecialMonkeyEscort extends BuffSkill {
    public SpecialMonkeyEscort() {
        this.setName("스페셜 몽키 에스코트");
        this.setDelay(780L);
        this.setCooldown(90.0);
        this.setRelatedSkill(new MonkeyBombBasic());
    }
}
