package org.mapledpmlab.type.skill.attackskill.paladin;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DivineJudgement extends AttackSkill {
    public DivineJudgement() {      // 블래스트 5회 사용마다 발동
        this.setName("디바인 저지먼트");
        this.setAttackCount(10L);
        this.setDamage(1160.0 + 410);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
