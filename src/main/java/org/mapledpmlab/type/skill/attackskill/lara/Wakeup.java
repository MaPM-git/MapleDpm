package org.mapledpmlab.type.skill.attackskill.lara;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Wakeup extends AttackSkill {
    public Wakeup() {
        this.setName("잠 깨우기");
        this.setDamage(1150.0);
        this.setAttackCount(4L);
        this.setCooldown(15.0 * 0.8);    // 잠 깨우기-쿨타임 리듀스
        this.setDelayByAttackSpeed(720L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setDotDuration(4000L);
        this.setInterval(90L);
        this.setLimitAttackCount(7L);
        this.addFinalDamage(1.08);      // 오버로드 마나
    }
}
