package org.mapledpmlab.type.skill.attackskill.lara;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EruptionSunriseWellVolcanicCoal extends AttackSkill {
    public EruptionSunriseWellVolcanicCoal() {
        this.setName("분출 : 해돋이 우물(화산탄)");
        this.setDamage(675.0);
        this.setAttackCount(3L);
        this.setRelatedSkill(new EruptionSunriseWellDot());
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);      // 오버로드 마나
        this.addIgnoreDefenseList(15L);     // 분출/흡수 - 이그노어 가드
        this.setAddDamage(10L + 15 + 21);   // 분출/흡수 - 리인포스, 보스 킬러
        this.setDotDuration(10700L);
        this.setInterval(2300L);
    }
}
