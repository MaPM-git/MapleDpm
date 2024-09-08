package org.mapledpmlab.type.skill.attackskill.marksman;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SplitArrow extends AttackSkill {
    public SplitArrow() {
        this.setName("스플릿 애로우");
        this.setAttackCount(6L);        // 어디셔널 볼트
        this.setDamage(1540.0);
        this.addIgnoreDefenseList(25L);
        this.addFinalDamage(1.6);       // 코어강화
    }
}
