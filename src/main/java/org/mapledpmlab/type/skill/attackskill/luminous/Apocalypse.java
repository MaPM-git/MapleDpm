package org.mapledpmlab.type.skill.attackskill.luminous;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Apocalypse extends AttackSkill {
    public Apocalypse() {
        this.setName("아포칼립스");
        this.setDamage(379.0);
        this.setDelayByAttackSpeed(960L);
        this.setAttackCount(7L * 2);
        this.addFinalDamage(0.75);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.05);  // 어둠 마법 강화
        this.setAddDamage(20L);     // 아포칼립스-리인포스
        this.addFinalDamage(1.08);  // 오버로드 마나
    }
}
