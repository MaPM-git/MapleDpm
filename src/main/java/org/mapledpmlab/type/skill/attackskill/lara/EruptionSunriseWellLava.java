package org.mapledpmlab.type.skill.attackskill.lara;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EruptionSunriseWellLava extends AttackSkill {
    public EruptionSunriseWellLava() {
        this.setName("분출 : 해돋이 우물(용암)");
        this.setDamage(570.0 + 48);
        this.setAttackCount(1L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new EruptionSunriseWellVolcanicCoal());
        this.setDotDuration(18000L);
        this.setInterval(1000L);
        this.addIgnoreDefenseList(15L);     // 분출/흡수 - 이그노어 가드
        this.setAddDamage(10L + 15 + 21);   // 분출/흡수 - 리인포스, 보스 킬러
    }
}
