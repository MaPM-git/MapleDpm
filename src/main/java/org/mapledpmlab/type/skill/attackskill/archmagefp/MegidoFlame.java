package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MegidoFlame extends AttackSkill {
    public MegidoFlame() {
        this.setName("메기도 플레임");
        this.setDamage(380.0);
        this.setAttackCount(4L);
        this.setCooldown(50.0);
        this.setDotDuration(60000L);    // 임의
        this.setInterval(100L);
        this.setLimitAttackCount(11L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.setRelatedSkill(new MegidoFlameDelay());
    }
}
