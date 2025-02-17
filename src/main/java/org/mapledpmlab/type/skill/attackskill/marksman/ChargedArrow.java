package org.mapledpmlab.type.skill.attackskill.marksman;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ChargedArrow extends AttackSkill {
    public ChargedArrow() {
        this.setName("차지드 애로우");
        this.setAttackCount(13L);       // 어디셔널 볼트
        this.setCooldown(20.0);
        this.setDamage(1870.0);
        this.setDelay(30L);
        this.addCriticalP(100.0);
        this.addIgnoreDefenseList(50L);
        this.setFinalDamage(1.6);       // 코어강화
        this.getMultiAttackInfo().add(100L);
        this.getMultiAttackInfo().add(390L);
    }
}
