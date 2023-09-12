package org.mapledpmlab.type.skill.attackskill.nightwalker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class QuintupleThrowDelay extends AttackSkill {
    public QuintupleThrowDelay() {
        this.setName("퀸터플 스로우");
        this.setDelay(240L);
        this.setRelatedSkill(new QuintupleThrowFinal());
    }
}
