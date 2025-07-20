package org.mapledpmlab.type.skill.buffskill.eunwol;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.eunwol.FoxSun;
import org.mapledpmlab.type.skill.attackskill.eunwol.LightOfTheFoxGoddessAlterEgo;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class LightOfTheFoxGoddess extends BuffSkill {
    public LightOfTheFoxGoddess() {
        this.setName("환혼요호진");
        this.setDuration(30L);
        this.addBuffFinalDamage(1.1);
        this.setCooldown(120.0);
        this.setRelatedSkill(new FoxSun());
    }
}
