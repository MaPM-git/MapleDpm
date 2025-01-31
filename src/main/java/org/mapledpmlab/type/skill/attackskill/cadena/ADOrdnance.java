package org.mapledpmlab.type.skill.attackskill.cadena;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ADOrdnance extends AttackSkill {
    public ADOrdnance() {
        this.setName("A.D 오드넌스");
        this.setDelayByAttackSpeed(450L);
        this.setDamage(495.0);
        this.setAttackCount(5L);
        this.setCooldown(25.0);
        this.setDotDuration(9120L);
        this.setInterval(210L);
        this.setLimitAttackCount(38L);
        this.addFinalDamage(1.6);           // 코어 강화
        this.setRelatedSkill(new ADOrdnanceSphere());
    }
}
