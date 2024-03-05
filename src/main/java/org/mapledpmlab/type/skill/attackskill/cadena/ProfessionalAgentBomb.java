package org.mapledpmlab.type.skill.attackskill.cadena;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ProfessionalAgentBomb extends AttackSkill {
    public ProfessionalAgentBomb() {
        this.setName("프로페셔널 에이전트(폭발)");
        this.setDamage(255.0);
        this.setAttackCount(3L);
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
