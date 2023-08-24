package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MiniCanonBall extends AttackSkill {
    public MiniCanonBall() {
        this.setName("미니 캐논볼");
        this.setDamage(360.0);
        this.setAttackCount(15L);       // 벅샷
        this.setCooldown(4.0);
        this.addFinalDamage(0.45);
        this.addFinalDamage(2.8);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
