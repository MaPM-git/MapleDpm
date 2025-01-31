package org.mapledpmlab.type.skill.attackskill.khali;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HexChakramSweep extends AttackSkill implements HexSkill {
    public HexChakramSweep() {
        this.setName("헥스 : 차크람 스윕");
        this.setDamage(1326.0);
        this.setAttackCount(7L);
        this.setCooldown(6.0);
        this.setDelayByAttackSpeed(780L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);    // 헥스-보스 킬러, 리인포스
        this.setApplyReuse(true);
    }
}
