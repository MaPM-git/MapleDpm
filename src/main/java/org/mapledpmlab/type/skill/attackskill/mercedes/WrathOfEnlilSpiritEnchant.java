package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WrathOfEnlilSpiritEnchant extends AttackSkill {
    public WrathOfEnlilSpiritEnchant() {
        this.setName("래쓰 오브 엔릴 : 스피릿 인챈트");
        this.setAttackCount(10L);
        this.setDamage(935.0);
        this.setDelayByAttackSpeed(900L);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.setCooldown(12.0);
    }
}
