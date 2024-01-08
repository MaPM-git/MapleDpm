package org.mapledpmlab.type.skill.attackskill.luminous;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PunishingResonatorEclipse extends AttackSkill {
    public PunishingResonatorEclipse() {
        this.setName("퍼니싱 리소네이터(이클립스)");
        this.setDamage(640.0);
        this.setAttackCount(5L);
        this.setDotDuration(6000L);
        this.setInterval(210L);
        this.setRelatedSkill(new PunishingResonatorDelay());
        this.addFinalDamage(1.6);       // 코어 강화
    }
}
