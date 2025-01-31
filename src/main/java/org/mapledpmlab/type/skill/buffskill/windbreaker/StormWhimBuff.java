package org.mapledpmlab.type.skill.buffskill.windbreaker;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class StormWhimBuff extends BuffSkill {
    public StormWhimBuff() {
        this.setName("스톰 윔");
        this.setDelayByAttackSpeed(810L);
        this.setDuration(30L);
        this.setCooldown(120.0);
    }
}
