package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class TriumphFeather extends AttackSkill {
    public TriumphFeather() {
        this.setName("트라이엄프 페더");
        this.setDamage(570.0);
        this.setAttackCount(4L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);          // 오버로드 마나
        this.addFinalDamage(0.583333333);   // 2번째부터 최종뎀 감소
        this.setCooldown(3.0);
        this.getMultiAttackInfo().add(360L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
    }
}
