package org.mapledpmlab.type.skill.attackskill.lara;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EruptionSunriseWell extends AttackSkill {
    public EruptionSunriseWell() {
        this.setName("분출 : 해돋이 우물(거인)");
        this.setDelayByAttackSpeed(450L);
        this.setDamage(1048.0 + 48);
        this.setAttackCount(6L);
        this.setCooldown(10.7);
        this.setApplyCooldownReduction(false);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new EruptionSunriseWellLava());
        this.addIgnoreDefenseList(15L);     // 분출/흡수 - 이그노어 가드
        this.setAddDamage(10L + 15 + 21);   // 분출/흡수 - 리인포스, 보스 킬러
    }
}
