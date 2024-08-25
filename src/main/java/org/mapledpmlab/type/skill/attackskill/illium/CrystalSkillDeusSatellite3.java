package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CrystalSkillDeusSatellite3 extends AttackSkill {
    public CrystalSkillDeusSatellite3() {
        this.setName("크리스탈 스킬:데우스(위성, 3단계)");
        this.setDamage(200.0 + 100);
        this.setAttackCount(1L + 1);
        this.setAddDamage(20L);     // 데우스-리인포스
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);  // 오버로드 마나
    }
}
