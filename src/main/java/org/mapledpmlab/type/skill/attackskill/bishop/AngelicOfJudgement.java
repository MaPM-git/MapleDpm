package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AngelicOfJudgement extends AttackSkill {
    public AngelicOfJudgement() {
        this.setName("엔젤레이(심판의 천사)");
        this.setDamage(820.0 + 35);
        this.setAttackCount(10L);
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
