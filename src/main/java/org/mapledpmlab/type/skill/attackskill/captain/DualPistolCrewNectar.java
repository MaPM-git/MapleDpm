package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DualPistolCrewNectar extends AttackSkill {
    public DualPistolCrewNectar() {
        this.setName("쌍권총 크루(언티어링 넥타)");
        this.setAttackCount(6L);
        this.setDamage(965.0);
        this.setInterval(1200L);
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
