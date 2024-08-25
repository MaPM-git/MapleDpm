package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MegidoFlameAfterSecond extends AttackSkill {
    public MegidoFlameAfterSecond() {
        this.setName("메기도 플레임(2타 이후)");
        this.setDamage(380.0);
        this.setAttackCount(4L);
        this.setDotDuration(60000L);
        this.setInterval(100L);
        this.setLimitAttackCount(10L);
        this.addFinalDamage(0.45);
        this.setApplyFinalAttack(true);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);      // 오버로드 마나
    }
}
