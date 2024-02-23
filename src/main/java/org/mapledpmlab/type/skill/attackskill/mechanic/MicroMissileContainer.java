package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MicroMissileContainer extends AttackSkill {
    public MicroMissileContainer() {
        this.setName("마이크로 미사일 컨테이너");
        this.setDelay(540L);
        this.setCooldown(25.0);
        this.setDotDuration(1200L);
        this.setInterval(30L);
        this.setAttackCount(5L);
        this.setDamage(935.0);
        this.addFinalDamage(1.6);           // 코어 강화
    }
}
