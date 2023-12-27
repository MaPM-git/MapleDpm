package org.mapledpmlab.type.skill.attackskill.xenon;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PinpointRocket extends AttackSkill {
    public PinpointRocket() {
        this.setName("핀포인트 로켓");
        this.setAttackCount(4L);
        this.setDamage(50.0 + 40 + 40 + 100);
        this.setCooldown(2.0);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
