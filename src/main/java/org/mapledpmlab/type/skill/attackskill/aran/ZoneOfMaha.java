package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ZoneOfMaha extends AttackSkill {
    public ZoneOfMaha() {
        this.setName("마하의 영역");
        this.setDamage(800.0 + 100);
        this.setAttackCount(5L);
        this.setDelay(30L);
        this.setCooldown(90.0);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new ZoneOfMahaContinue());
    }
}
