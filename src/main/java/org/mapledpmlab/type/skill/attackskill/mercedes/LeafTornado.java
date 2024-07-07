package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LeafTornado extends AttackSkill {
    public LeafTornado() {
        this.setName("리프 토네이도");
        this.setAttackCount(4L);
        this.setDamage(780.0 + 30);         // 레전드리 스피어-링크드 리인포스
        this.setDelayByAttackSpeed(750L);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
