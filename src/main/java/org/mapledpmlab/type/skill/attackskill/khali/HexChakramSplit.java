package org.mapledpmlab.type.skill.attackskill.khali;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HexChakramSplit extends AttackSkill implements HexSkill {
    public HexChakramSplit() {
        this.setName("헥스 : 차크람 스플릿");
        this.setDamage(500.0);
        this.setAttackCount(5L * 4);
        this.setCooldown(14.0);
        this.setDelayByAttackSpeed(720L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);    // 헥스-보스 킬러, 리인포스
        this.setApplyReuse(true);
    }
}
