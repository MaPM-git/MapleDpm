package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DualPistolCrew extends AttackSkill {
    public DualPistolCrew() {
        this.setName("쌍권총 크루");
        this.setAttackCount(6L);
        this.setDamage(150.0 + 200);    // 어셈블 크루
        this.setInterval(3030L);
        this.addFinalDamage(1.16);      // 크루 커맨더십
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
