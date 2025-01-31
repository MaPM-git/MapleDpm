package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CrystalSkillDeusSatellite extends AttackSkill {
    public CrystalSkillDeusSatellite() {
        this.setName("크리스탈 스킬:데우스(위성)");
        this.setDamage(232.0);
        this.setAttackCount(1L + 1);
        this.setDotDuration((long) (30000L * 1.32));
        this.setInterval(180L);
        //this.setLimitAttackCount(120L);
        this.setAddDamage(20L);     // 데우스-리인포스
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);  // 오버로드 마나
    }
}
