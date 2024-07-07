package org.mapledpmlab.type.skill.attackskill.khali;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HexChakramFury extends AttackSkill implements HexSkill {
    public HexChakramFury() {
        this.setName("헥스 : 차크람 퓨리");
        this.setDamage(556.0);
        this.setAttackCount(10L);
        this.setDelay(540L);
        this.setDotDuration(120L);
        this.setInterval(30L);
        this.setLimitAttackCount(4L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);    // 헥스-보스 킬러, 리인포스
    }
}
