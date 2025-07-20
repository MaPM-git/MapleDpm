package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Restore extends AttackSkill {
    public Restore() {
        this.setName("리스토어");
        this.setDamage(1980.0);
        this.setAttackCount(3L);
        this.setDotDuration(20000L + 3000);
        this.setInterval(2000L);
        this.addFinalDamage(1.6);   // 코어 강화
    }
}
