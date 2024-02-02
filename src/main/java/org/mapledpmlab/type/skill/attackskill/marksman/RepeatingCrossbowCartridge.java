package org.mapledpmlab.type.skill.attackskill.marksman;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RepeatingCrossbowCartridge extends AttackSkill {
    public RepeatingCrossbowCartridge() {
        this.setName("리피팅 크로스보우 카트리지");
        this.setAttackCount(10L);       // 어디셔널 볼트
        this.setDamage(825.0);
        this.setDelay(1080L);
        this.setDotDuration(1080L);
        this.setLimitAttackCount(270L);
        this.addIgnoreDefenseList(25L);
        this.addCriticalP(100.0);
        this.setInterval(202L);
        this.addFinalDamage(1.6);       // 코어 강화
    }
}
