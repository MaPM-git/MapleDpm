package org.mapledpmlab.type.skill.attackskill.archmageil;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SpiritOfSnow extends AttackSkill {
    public SpiritOfSnow() {
        this.setName("스피릿 오브 스노우");
        this.setDamage(1870.0);
        this.setAttackCount(9L);
        this.setDelay(720L);
        this.setDotDuration(30000L);
        this.setInterval(3000L);
        this.addFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
