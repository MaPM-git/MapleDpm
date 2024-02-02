package org.mapledpmlab.type.skill.attackskill.marksman;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class TrueSnipe extends AttackSkill {
    public TrueSnipe() {
        this.setName("트루 스나이핑");
        this.setAttackCount(15L);       // 어디셔널 볼트
        this.setCooldown(60.0);
        this.setDamage(1850.0);
        this.setDelay(120L);
        this.setDotDuration(120L);
        this.setLimitAttackCount(4L);
        this.setInterval(30L);
        this.setAddDamage(100L);
        this.addIgnoreDefenseList(100L);
        this.setFinalDamage(1.6);       // 코어강화
    }
}
