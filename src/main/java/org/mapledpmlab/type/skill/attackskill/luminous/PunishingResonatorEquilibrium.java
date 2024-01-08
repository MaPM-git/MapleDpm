package org.mapledpmlab.type.skill.attackskill.luminous;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PunishingResonatorEquilibrium extends AttackSkill {
    public PunishingResonatorEquilibrium() {
        this.setName("퍼니싱 리소네이터(이퀄리브리엄)");
        this.setDamage(935.0);
        this.setAttackCount(6L);
        this.setDotDuration(6000L);
        this.setInterval(210L);
        this.setRelatedSkill(new PunishingResonatorDelay());
        this.addFinalDamage(1.6);       // 코어 강화
    }
}
