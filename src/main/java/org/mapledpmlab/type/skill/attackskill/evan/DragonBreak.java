package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DragonBreak extends AttackSkill {
    public DragonBreak() {
        this.setName("드래곤 브레이크");
        this.setDamage(1540.0);
        this.setAttackCount(8L);
        this.setDelay(30L);
        this.setDotDuration(2500L);
        this.setInterval(360L);
        this.setLimitAttackCount(6L);
        this.setCooldown(20.0);
        this.addFinalDamage(1.6);           // 코어 강화
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
