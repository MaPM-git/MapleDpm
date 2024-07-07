package org.mapledpmlab.type.skill.attackskill.xenon;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class TriangleFormationPlasma extends AttackSkill {
    public TriangleFormationPlasma() {
        this.setName("트라이앵글 포메이션(플라즈마 전류)");
        this.setAttackCount(4L);
        this.setDamage(240.0);
        this.addFinalDamage(2.8);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
    }
}
