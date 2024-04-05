package org.mapledpmlab.type.skill.buffskill.hoyoung;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class AllCreationOfHeavenAndEarth extends BuffSkill {
    public AllCreationOfHeavenAndEarth() {
        this.setName("천지만물");
        this.setDuration(40L);
        this.setCooldown(30.0);
        this.addBuffFinalDamage(1.1);
    }
}
