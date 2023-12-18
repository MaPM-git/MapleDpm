package org.mapledpmlab.type.skill.attackskill.battlemage;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CrimsonPactum1Delay extends AttackSkill {
    public CrimsonPactum1Delay() {
        this.setName("크림슨 팩텀1");
        this.setDelay(3900L);
        this.setRelatedSkill(new CrimsonPactum2());
    }
}
