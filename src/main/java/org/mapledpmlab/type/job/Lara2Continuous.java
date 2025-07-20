package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.PassiveBossAbnormal;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.link.NatureFriend;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.IntUnion;

import java.util.stream.Collectors;

public class Lara2Continuous extends Job {

    public Lara2Continuous() {
        // 기본
        super();
        this.setName("라라(2초, 컨티)");
        this.setConstant(1.2);          // 무기상수
        this.setMastery(1.97 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION2);

        this.setAscentDamage(2356410.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addMagic((long) (400 + 246 + 72 + 274));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addMagicP(9L);
        passive.addMagicP(21L);
        passive.addMagicP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (400 + 246 + 72 + 274));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat(10L);
        passive.addSubStat(10L);
        passive.addMagic(3L);
        //passive.addBossDamage(70L);
        //passive.addMagicP(9L);
        passive.addBossDamage(30L);
        passive.addMagicP(21L);
        passive.addMagicP(21L);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("지팡이 숙련");
        passive.addMagic(35L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("신체 단련");
        passive.addMainStat(40L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("무구");
        passive.addDamage(20L);
        passive.addBossDamage(10L);
        passive.addCriticalP(20.0);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("고급 지팡이 숙련");
        passive.addFinalDamage(1.31);
        passive.addMagic(52L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("혜안");
        passive.addCriticalP(22.0);
        passive.addCriticalDamage(22.0);
        passive.addFinalDamage(1.47);
        passive.addIgnoreDefenseList(42L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("유유");
        passive.addMagic(54L);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(9L);
        this.addMainStat(-2L);
        this.addSubStat(10L);

        this.setAbility(new PassiveBossAbnormal());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new PhantomInstinct());
        this.getLinkList().add(new NatureFriend());
        this.setUnion(new IntUnion());
        this.addPerXMainStat(20L);

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }

    @Override
    public void Doping() {
        super.Doping();

        Common doping = new Common();
        doping.setDescription("용맥의 메아리");
        doping.addFinalDamage(1.05);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("고급 지팡이 숙련(콜렉터의 영약)");
        doping.addMagic(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("혜안(콜렉터의 영약)");
        doping.addCriticalDamage(1.0);
        doping.minusFinalDamage(1.47);
        doping.addFinalDamage(1.48);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("유유(콜렉터의 영약)");
        doping.addMagic(2L);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }

    public Long getStatDamage() {
        return (long) Math.floor(
                (this.getFinalMainStat() * 4 + getFinalSubstat()) * 0.01
                        * Math.floor(this.getMagic() * (1 + this.getMagicP() * 0.01))
                        * this.getConstant()
                        * (1 + this.getDamage() * 0.01)
                        * this.getFinalDamage()
        );
    }
}
