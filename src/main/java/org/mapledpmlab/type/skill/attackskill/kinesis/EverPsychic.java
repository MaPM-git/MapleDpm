package org.mapledpmlab.type.skill.attackskill.kinesis;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EverPsychic extends AttackSkill {
    public EverPsychic() {
        this.setName("에버싸이킥");
        this.setDamage(400.0);
        this.setAttackCount(1L);
        this.setDotDuration(120L * 16);
        this.setInterval(120L);
        this.setLimitAttackCount(16L);
        this.setDelay(60L);
        this.setCooldown(120.0);
        this.setRelatedSkill(new EverPsychicFinish());
    }
}
