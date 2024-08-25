package org.mapledpmlab.type.skill.attackskill.striker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SeaWaveThunderboltFlash extends AttackSkill {
    public SeaWaveThunderboltFlash() {
        this.setName("해파(벽력섬)");
        this.setAttackCount(4L * 2);
        this.setDamage(190.0 + 102);        // 윈드 부스터
        this.addFinalDamage(0.855);         // 축뢰
        this.addFinalDamage(4.0);           // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
