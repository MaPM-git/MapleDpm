package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LeafTornadoSpiritEnchant extends AttackSkill {
    public LeafTornadoSpiritEnchant() {
        this.setName("리프 토네이도 : 스피릿 인챈트");
        this.setAttackCount(4L);
        this.setDamage(860.0 + 30);         // 레전드리 스피어-링크드 리인포스
        this.setDelayByAttackSpeed(750L);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.setCooldown(6.0);
    }
}
