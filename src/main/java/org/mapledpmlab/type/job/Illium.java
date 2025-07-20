package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.ReuseBossAbnormal;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.FlowOfBattle;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.IntUnion;

import java.util.stream.Collectors;

public class Illium extends Job {

    public Illium() {
        // 기본
        super();
        this.setName("일리움(0초, 리웨)");
        this.setConstant(1.2);          // 무기상수
        this.setMastery(1.90 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

        this.setAscentDamage(2933775.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addMagic((long) (992));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addMagicP(9L);
        passive.addMagicP(21L);
        passive.addMagicP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (992));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat(10L);
        passive.addSubStat(10L);
        passive.addMagic(3L);
        passive.addBossDamage(70L);
        passive.addMagicP(9L);
        passive.addMagicP(21L);
        getPassiveList().add(passive);
        
        // 1차
        passive = new Common();
        passive.setDescription("매직 건틀렛 마스터리");
        passive.addCriticalP(20.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("블레스 마크");
        passive.addDamage(10L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("레프 마스터리");
        passive.addDamage(15L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("운명 개척");
        passive.addMainStat(40L);
        passive.addMagicP(10L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("끊임없는 연구");
        passive.addMagic(50L);
        passive.addCriticalDamage(30.0);
        passive.addCriticalP(20.0);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("크리스탈의 비밀");
        passive.addBossDamage(30L);
        passive.addIgnoreDefenseList(25L);
        passive.addFinalDamage(1.47);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("소드 오브 크리스탈 강화");
        passive.addMainStat(90L);
        passive.addSubStat(90L);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(27L);
        this.addMainStat(-2L);
        this.addSubStat(10L);

        this.setAbility(new ReuseBossAbnormal());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new PhantomInstinct());
        this.getLinkList().add(new FlowOfBattle());
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
        doping.setDescription("커스 마크");
        doping.addIgnoreDefenseList(20L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("블레스 마크");
        doping.addAtt(46L);
        doping.addMagic(46L);
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
