package org.mapledpmlab.type.skill.attackskill.nightwalker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class QuintupleThrowBlackDelay extends AttackSkill {
    public QuintupleThrowBlackDelay() {
        this.setName("퀸터플 스로우(칠흑 표창)");
        this.setDelay(240L);
        this.setRelatedSkill(new QuintupleThrowBlackFinal());
    }
}
