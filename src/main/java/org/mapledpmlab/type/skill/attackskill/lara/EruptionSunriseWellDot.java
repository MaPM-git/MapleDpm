package org.mapledpmlab.type.skill.attackskill.lara;

import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;

public class EruptionSunriseWellDot extends DotAttackSkill {
    public EruptionSunriseWellDot() {
        this.setName("분출 : 해돋이 우물(도트)");
        this.setDamage(195.0);
        this.setAttackCount(1L);
        this.setDotDuration(18000L);
        this.setInterval(1000L);
        this.addIgnoreDefenseList(15L);     // 분출/흡수 - 이그노어 가드
        this.setAddDamage(10L + 15 + 21);   // 분출/흡수 - 리인포스, 보스 킬러
    }
}
