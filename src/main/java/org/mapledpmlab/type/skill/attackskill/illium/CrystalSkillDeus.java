package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CrystalSkillDeus extends AttackSkill {
    public CrystalSkillDeus() {
        this.setName("크리스탈 스킬:데우스");
        this.setDamage(504.0);
        this.setDelayByAttackSpeed(30L);
        this.setAttackCount(5L + 1);
        this.setCooldown(30.0);
        this.setApplyCooldownReduction(false);
        this.setDotDuration(30000L);
        this.setInterval(3300L);
        this.setAddDamage(20L);     // 데우스-리인포스
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new CrystalSkillDeusSatellite1());
        this.addFinalDamage(1.08);  // 오버로드 마나
    }
}
