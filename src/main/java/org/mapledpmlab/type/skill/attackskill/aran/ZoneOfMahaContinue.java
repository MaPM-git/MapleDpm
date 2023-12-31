package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ZoneOfMahaContinue extends AttackSkill {
    public ZoneOfMahaContinue() {
        this.setName("마하의 영역(지속)");
        this.setDamage(500.0 + 100);
        this.setAttackCount(3L);
        this.setDotDuration(8000L);
        this.setInterval(1000L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}

