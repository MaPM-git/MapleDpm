package org.mapledpmlab.type.skill.attackskill.luminous;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PunishingResonatorSunfire extends AttackSkill {
    public PunishingResonatorSunfire() {
        this.setName("퍼니싱 리소네이터(선파이어)");
        this.setDamage(1155.0);
        this.setAttackCount(4L);
        this.setDotDuration(6000L);
        this.setInterval(210L);
        this.setDelay(780L);
        this.addFinalDamage(1.6);       // 코어 강화
        this.addFinalDamage(1.08);  // 오버로드 마나
    }
}
